package StrategyDesignPrinciple;

interface WalkableRobot{
    void walk();
}

class NormalWalk implements WalkableRobot{
    public void walk(){
        System.out.println("Walking normally...");
    }
}

class NoWalk implements WalkableRobot{
    public void walk(){
        System.out.println("Cannot walk...");
    }
}

interface TalkableRobot{
    void talk();
}

class NormalTalk implements TalkableRobot{
    public void talk(){
        System.out.println("Talking normally...");
    }
}

class NoTalk implements TalkableRobot{
    public void talk(){
        System.out.println("Cannot talk.");
    }
}

interface FlyableRobot{
    void fly();
}

class NormalFy implements FlyableRobot{
    public void fly(){
        System.out.println("Flying normally...");
    }
}

class NoFly implements FlyableRobot{
    public void fly(){
        System.out.println("Cannot fly");
    }
}

abstract class Robot{
    protected WalkableRobot walkBehaviour;
    protected TalkableRobot talkBehaviour;
    protected FlyableRobot flyBehaviour;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        this.walkBehaviour = w;
        this.talkBehaviour = t;
        this.flyBehaviour = f;
    }

    public void walk(){
        walkBehaviour.walk();
    }

    public void talk(){
        talkBehaviour.talk();
    }
    public void fly(){
        flyBehaviour.fly();
    }

    public abstract void projection();
}

class CompanionRobot extends Robot{
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        super(w, t, f);
    }

    public void projection(){
        System.out.println("Displaying friendly companion features...");
    }
}


class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}
public class StrategyDesignClient{
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("---------------------");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFy());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}

