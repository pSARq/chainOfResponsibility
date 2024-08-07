package org.example4;

public class Main {
    public static void main(String[] args) {
        /*Este es un ejemplo de aprobar un presupuesto, según la importancia del rol
         cada uno tiene un límite de aprobación, entonces el precio pasa por cada uno
         hasta que alguno lo acepte*/
        Approver teamLead = new TeamLead();
        Approver departmentHead = new DepartmentHead();
        Approver ceo = new CEO();

        teamLead.setNextApprover(departmentHead);
        departmentHead.setNextApprover(ceo);

        teamLead.approveExpense(500);
        teamLead.approveExpense(1500);
        teamLead.approveExpense(20000);
    }
}
