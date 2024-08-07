package org.example4;

public abstract class Approver {
    protected Approver nextApprover;
    protected int approvalLimit;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void approveExpense(int amount) {
        if (amount <= approvalLimit) {
            System.out.println("Aprobado por " + this.getClass().getSimpleName());
        } else if (nextApprover != null) {
            nextApprover.approveExpense(amount);
        } else {
            System.out.println("Gasto no aprobado");
        }
    }
}
