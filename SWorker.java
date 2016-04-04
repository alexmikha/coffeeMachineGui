import javax.swing.*;

class SWorker extends SwingWorker<Object, Object> {

    private Gui gui;

    SWorker(Gui sworker) {
        this.gui = sworker;
    }

    @Override
    protected Object doInBackground() throws Exception {
        for (int i = 1; i < 6; i++) {
            Thread.sleep(1090);
        }
        return null;
    }

    @Override
    protected void done() {
        gui.removeAnimDrink();
        gui.removeAnimInsertOutMoney();
        gui.getTextArea1().setText(" ");
        gui.cleanedIngr();
        gui.crowdedBank();
        gui.selectDrink();
    }
}
