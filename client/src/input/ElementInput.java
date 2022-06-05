package input;

import data.Car;
import data.HumanBeing;
import data.Coordinates;
import java.util.Scanner;
import checkCorrectInput.CheckCorrectData;
import data.WeaponType;

public class ElementInput
{
    private String name;
    private String soundtrack;
    private String car;
    private WeaponType weaponType;
    private Float x;
    private Float y;
    private Boolean realHero;
    private Boolean hasToothpick;
    private Long impactSpeed;
    private Integer minutesOfWaiting;
    private CheckCorrectData check;

    public ElementInput() {
        this.check = new CheckCorrectData();
    }

    public void nameInput() {
        while (true) {
            final Scanner input = new Scanner(System.in);
            System.out.print("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0438\u043c\u044f: ");
            this.name = input.nextLine().trim();
            if (this.check.checkName(this.name) == 1) {
                break;
            }
            System.out.println("\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u0432\u0432\u043e\u0434. \u041f\u043e\u043f\u0440\u043e\u0431\u0443\u0439\u0442\u0435 \u0435\u0449\u0435 \u0440\u0430\u0437.");
        }
    }

    public void xInput() {
        while (true) {
            final Scanner input = new Scanner(System.in);
            System.out.print("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0443 x: ");
            if (input.hasNextFloat()) {
                this.x = input.nextFloat();
                if (this.check.checkCoordinateX(this.x) == 1) {
                    break;
                }
            }
            System.out.println("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u0438\u043b\u0438 \u0447\u0438\u0441\u043b\u043e \u043f\u0440\u0435\u0432\u044b\u0448\u0430\u0435\u0442 " + Coordinates.getMaxX());
        }
    }

    public void yInput() {
        while (true) {
            final Scanner input = new Scanner(System.in);
            System.out.print("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0443 y: ");
            if (input.hasNextFloat()) {
                this.y = input.nextFloat();
                if (this.check.checkCoordinateY(this.y) == 1) {
                    break;
                }
            }
            System.out.println("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u0438\u043b\u0438 \u0447\u0438\u0441\u043b\u043e \u043f\u0440\u0435\u0432\u044b\u0448\u0430\u0435\u0442 " + Coordinates.getMaxY());
        }
    }

    public void realHeroInput() {
        while (true) {
            final Scanner input = new Scanner(System.in);
            System.out.print("\u042f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0433\u0435\u0440\u043e\u0435\u043c: ");
            if (input.hasNextBoolean()) {
                this.realHero = input.nextBoolean();
                if (this.check.checkRealHero(this.realHero) == 1) {
                    break;
                }
            }
            System.out.println("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043b\u0438\u0431\u043e true \u043b\u0438\u0431\u043e false!");
        }
    }

    public void hasToothpickInput() {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            System.out.print("\u0415\u0441\u0442\u044c \u0437\u0443\u0431\u043e\u0447\u0438\u0441\u0442\u043a\u0430: ");
            if (input.hasNextBoolean()) {
                break;
            }
            System.out.println("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043b\u0438\u0431\u043e true \u043b\u0438\u0431\u043e false!");
        }
        this.hasToothpick = input.nextBoolean();
    }

    public void impactSpeedInput() {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            System.out.print("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c: ");
            if (input.hasNextLong()) {
                break;
            }
            System.out.println("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0446\u0435\u043b\u043e\u0435 \u0447\u0438\u0441\u043b\u043e!");
        }
        this.impactSpeed = input.nextLong();
    }

    public void soundtrackInput() {
        while (true) {
            final Scanner input = new Scanner(System.in);
            System.out.print("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0438\u043c\u044f \u0441\u0430\u0443\u043d\u0434\u0442\u0440\u0435\u043a\u0430: ");
            this.soundtrack = input.nextLine().trim();
            if (this.check.checkSoundtrackName(this.soundtrack) == 1) {
                break;
            }
            System.out.println("\u041d\u0435\u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u044b\u0439 \u0432\u0432\u043e\u0434. \u0421\u0442\u0440\u043e\u043a\u0430 \u0434\u043e\u043b\u0436\u043d\u0430 \u0431\u044b\u0442\u044c \u043d\u0435 \u043f\u0443\u0441\u0442\u043e\u0439!");
        }
    }

    public void minutesOfWaitingInput() {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            System.out.print("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0432\u0440\u0435\u043c\u044f \u043e\u0436\u0438\u0434\u0430\u043d\u0438\u044f: ");
            if (input.hasNextInt()) {
                break;
            }
            System.out.println("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043b\u043e!");
        }
        this.minutesOfWaiting = input.nextInt();
    }

    public void weaponTypeInput() {
        String inputWeaponType;
        while (true) {
            final Scanner input = new Scanner(System.in);
            System.out.println("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043b\u043e, \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044e\u0449\u0435\u0435 \u0432\u044b\u0431\u0440\u0430\u043d\u043d\u043e\u043c\u0443 \u0442\u0438\u043f\u0443 \u043e\u0440\u0443\u0436\u0438\u044f. \u0412\u043e\u0437\u043c\u043e\u0436\u043d\u044b\u0435 \u0432\u0430\u0440\u0438\u0430\u043d\u0442\u044b: ");
            WeaponType.outputWeaponType();
            inputWeaponType = input.nextLine().trim();
            if (this.check.checkWeaponType(inputWeaponType) == 1) {
                break;
            }
            System.out.println("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043b\u043e \u0438\u0437 \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0435\u043d\u043d\u043e\u0433\u043e \u0441\u043f\u0438\u0441\u043a\u0430.");
        }
        this.weaponType = WeaponType.stringValue(inputWeaponType);
    }

    public void carInput() {
        while (true) {
            final Scanner input = new Scanner(System.in);
            System.out.print("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043c\u0430\u0440\u043a\u0443 \u043c\u0430\u0448\u0438\u043d\u044b: ");
            if (input.hasNextLine()) {
                this.car = input.nextLine().trim();
                if (this.check.checkCar(this.car) == 1) {
                    break;
                }
            }
            System.out.println("\u041d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u0432\u0432\u043e\u0434.");
        }
    }

    public HumanBeing createElement(final Long id) {
        return new HumanBeing(id, this.name, new Coordinates(this.x, this.y), this.realHero, this.hasToothpick, this.impactSpeed, this.soundtrack, this.minutesOfWaiting, this.weaponType, new Car(this.car));
    }

    public HumanBeing resultElement(final Long id) {
        this.nameInput();
        this.xInput();
        this.yInput();
        this.realHeroInput();
        this.hasToothpickInput();
        this.impactSpeedInput();
        this.minutesOfWaitingInput();
        this.soundtrackInput();
        this.weaponTypeInput();
        this.carInput();
        return this.createElement(id);
    }
}