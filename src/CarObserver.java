public class CarObserver {
    private CarView frame;
    public void notifyFrame(){
        frame.drawPanel.repaint();
    }

    public void setFrame(CarView frame) {
        this.frame = frame;
    }
}
