//package br.com.fiap.health.services;
//
//import br.com.fiap.health.model.Atividade;
//import br.com.fiap.health.model.ExerciciosDiarios;
//import br.com.fiap.health.model.FrequenciaCardiaca;
//import br.com.fiap.health.model.HistoricoCoracao;
//import br.com.fiap.health.model.MonitorFrequenciaCardiaca;
//import br.com.fiap.health.model.Passos;
//import br.com.fiap.health.model.PassosHistorySingleton;
//import br.com.fiap.health.model.TipoAtividade;
//import br.com.fiap.health.model.Treino;
//import br.com.fiap.health.model.Usuario;
//
//public class Main {
//    public static void main(String args[]) {
//        System.out.println("Iniciando o App Health Track");
//        
//        Usuario usuario = new Usuario();
//        
////        System.out.println(usuario.getPeso());
////        
////        Usuario usuario2 = new Usuario(new Date(), 90, 180);
////        
////        System.out.println(usuario2.getPeso());
//        
//        Atividade atividade = new Atividade(TipoAtividade.SONO);
//        
//        System.out.println("Tipo da Atividade " + atividade.getAtividade());
//        
//        //############### TREINO ################
//        Treino treino = new Treino();
//        
//        treino.start();
//        
//        System.out.println("Treino Ativo " + treino.isReading);
//        
//        treino.stop();
//        
//        System.out.println("Treino Ativo " + treino.isReading);
//        
//        //############### TREINO ################
//        
//        //############### CONTROLE CARD�ACO ################
//        FrequenciaCardiaca cardiaca = new FrequenciaCardiaca(100.0);
//        
//        HistoricoCoracao historicoCoracao = new HistoricoCoracao();
//        
//        historicoCoracao.addFrequenciaCradiaca(cardiaca);
//        historicoCoracao.addFrequenciaCradiaca(cardiaca);
//        
//        System.out.println(historicoCoracao.historicoTotal());
//        
//        MonitorFrequenciaCardiaca monitorFrequenciaCardiaca = new MonitorFrequenciaCardiaca();
//        
//        monitorFrequenciaCardiaca.start();
//        System.out.println("Monitor Ligado " + monitorFrequenciaCardiaca.isReading);
//        System.out.println("Monitor Frequencia Card�aca " + monitorFrequenciaCardiaca.read());
//        
//        //############### CONTROLE CARD�ACO ################
//        
//        //############### EXERC�CIOS ################
//        ExerciciosDiarios diarios = new ExerciciosDiarios(1);
//        
//        Passos steps = new Passos();
//        
//        steps.startCounter();
//        
//        steps.saveDailyCount();
//
//        System.out.println(steps.getNumSteps());
//        
//        steps.stopCounter();
//        
//        PassosHistorySingleton historySingleton = new PassosHistorySingleton();
//        
//        historySingleton.addDailyCount(diarios);
//        historySingleton.addDailyCount(diarios);
//
//        System.out.println("Quantidade de Exerc�cios Dia " + historySingleton.historySize());
//        //############### EXERC�CIOS ################
//    }
//}