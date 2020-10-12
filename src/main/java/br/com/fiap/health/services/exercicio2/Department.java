package br.com.fiap.health.services.exercicio2;

public class Department {

    private Integer departmentId;
    private String name;

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String toString() {
        return name;
    }
}
