import javax.swing.*;

class SWorker1 extends SwingWorker<Object, Object> {

    private Gui gui;

    SWorker1(Gui sworker1) {
        this.gui = sworker1;
    }

    @Override
    protected Object doInBackground() throws Exception {
        for (int i = 1; i < 4; i++) {
            Thread.sleep(1080);
        }
        return null;
    }

    @Override
    protected void done() {
        if (gui.viewInsertMoney())
            gui.removeAnimInsertMoney();
        if (gui.getTextField1().getText().contains("Espresso"))
            gui.putMoneyEspresso();
        if (gui.getTextField1().getText().contains("Americano"))
            gui.putMoneyAmericano();
        if (gui.getTextField1().getText().contains("Cappuccino"))
            gui.putMoneyCappuccino();

        if (CheckMoney.verifyMoney == 1 && CheckMoney.verifyMoney != 2) {
            if (gui.viewInsertMoney())
                gui.removeAnimInsertMoney();
            gui.addMoney();
        }

        if (CheckMoney.verifyMoney == 0) {
            gui.viewOutMoney();
            gui.takeBadMoney();
        }
    }
}

