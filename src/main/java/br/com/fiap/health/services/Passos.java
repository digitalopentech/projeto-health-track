package br.com.fiap.health.services;

public class Passos {
	private static final int walkingSpeed = 500;

	private Thread stepThread;
	private Atividade sensor;
	private int numSteps;

	/**
	 * Inicializar numSteps para zero Cria
	 * Inicia nosso leitor de etapas do aceler�metro
	 */
	public Passos() {
		numSteps = new Integer(0);
		sensor = new Atividade();
	}

	/**
	 * Come�a a fazer leituras do Sensor do Aceler�metro
	 */
	public boolean startCounter() {
		if (!sensor.isReading) {
			sensor.start();

			Runnable stepRunnable = new Runnable() {
				public void run() {
					try {
						while (sensor.isReading) {
							int speed = sensor.read();
							if (speed > walkingSpeed)
								numSteps = numSteps + 1;

							Thread.sleep(500);
						}
					} catch (InterruptedException e) {
						sensor.stop();
					}
				}
			};

			stepThread = new Thread(stepRunnable);
			stepThread.start();
			return true;
		}

		return false;
	}

	/**
	 * Stops the Accelerometer Sensor from taking more readings
	 */
	public void stopCounter() {
		sensor.stop();
	}

	/**
	 * Reset the step count to 0 Stops the sensor from reading steps
	 */
	public void resetSteps() {
		numSteps = 0;
	}

	public double getNumSteps() {
		return numSteps;
	}

	public Integer numStepsProperty() {
		return numSteps;
	}

	/**
	 * Create a DailySteps copy of this object to save the daily count
	 * 
	 * @return
	 */
	public ExerciciosDiarios saveDailyCount() {
		return new ExerciciosDiarios(numSteps);
	}
}
