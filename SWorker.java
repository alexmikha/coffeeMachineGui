import javax.swing.*;

public class SWorker extends SwingWorker<Object, Object> {

    Gui gui;
//AdminIngradient adminIngr;
//    private List<Object> chunks;

    public SWorker(Gui sworker) {
        this.gui = sworker;
    }
//    public SWorker(AdminIngradient sworker) {
//        this.adminIngr = sworker;
//    }


    @Override
    protected Object doInBackground() throws Exception {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1050);
        }
        return null;
    }

//    @Override
//    protected void process(List<Object> chunks) {
//        this.chunks = chunks;
//        super.process(chunks);
//        gui.viewCoffeeDrink();
//    }

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
