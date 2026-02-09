package CommandDesignPattern;

interface Command{
    void execute();
    void undo();
}

class Light{
    public void on(){
        System.out.println("Light is ON");
    }
    public void off(){
        System.out.println("Light is OFF");
    }
}

class Fan {
    public void on()  {
        System.out.println("Fan is ON");
    }
    public void off() {
        System.out.println("Fan is OFF");
    }
}

class LightCommand implements Command{
    private Light light;
    public LightCommand(Light l){
        this.light = l;
    }

    public void execute(){
        light.on();
    }

    public void undo(){
        light.off();
    }
}

class FanCommand implements Command {
    private Fan fan;

    public FanCommand(Fan f) {
        this.fan = f;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        fan.off();
    }
}

class RemoteController{
    private static final int numButtons = 4;
    private Command[] buttons;
    private boolean[] buttonPressed;

    public RemoteController(){
        buttons = new Command[numButtons];
        buttonPressed = new boolean[numButtons];
        for(int i=0;i<numButtons;i++){
            buttons[i] = null;
            buttonPressed[i] = false;
        }
    }

    public void setCommand(int index, Command command){
        if(index >= 0 && index < numButtons){
            buttons[index] = command;
            buttonPressed[index] = false;
        }
    }

    public void pressButton(int index){
        if(index >= 0 && index < numButtons && buttons[index] != null){
            if(!buttonPressed[index]){
                buttons[index].execute();
            }
            else{
                buttons[index].undo();
            }
            buttonPressed[index] = !buttonPressed[index];
        }
        else{
            System.out.println("No command assigned at button " + index);
        }
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        RemoteController remote = new RemoteController();

        remote.setCommand(0, new LightCommand(livingRoomLight));
        remote.setCommand(1, new FanCommand(ceilingFan));

        // Simulate button presses (toggle behavior)
        System.out.println("--- Toggling Light Button 0 ---");
        remote.pressButton(0);  // ON
        remote.pressButton(0);  // OFF

        System.out.println("--- Toggling Fan Button 1 ---");
        remote.pressButton(1);  // ON
        remote.pressButton(1);  // OFF

        // Press unassigned button to show default message
        System.out.println("--- Pressing Unassigned Button 2 ---");
        remote.pressButton(2);
    }
}
