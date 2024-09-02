//Made By Anish
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
public class BasicMovement extends OpMode {

    // Declare motors
    DcMotor motorLeftBack;
    DcMotor motorLeftFront;
    DcMotor motorRightBack;
    DcMotor motorRightFront;

    @Override
    public void init() {
        // Initialize motors
        motorLeftBack = hardwareMap.dcMotor.get("left_back_Motor");
        motorLeftFront = hardwareMap.dcMotor.get("left_front_Motor");
        motorRightBack = hardwareMap.dcMotor.get("right_back_Motor");
        motorRightFront = hardwareMap.dcMotor.get("right_front_Motor");

        // Set motor directions
        motorLeftBack.setDirection(DcMotor.Direction.FORWARD);
        motorLeftFront.setDirection(DcMotor.Direction.FORWARD);
        motorRightBack.setDirection(DcMotor.Direction.REVERSE);
        motorRightFront.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        // Move forward
        if (gamepad1.left_stick_y > 0) {
            motorLeftBack.setPower(gamepad1.left_stick_y);
            motorLeftFront.setPower(gamepad1.left_stick_y);
            motorRightBack.setPower(gamepad1.left_stick_y);
            motorRightFront.setPower(gamepad1.left_stick_y);
        }
        // Move backward
        else if (gamepad1.left_stick_y < 0) {
            motorLeftBack.setPower(gamepad1.left_stick_y);
            motorLeftFront.setPower(gamepad1.left_stick_y);
            motorRightBack.setPower(gamepad1.left_stick_y);
            motorRightFront.setPower(gamepad1.left_stick_y);
        }


        // Strafe/Move to the left direction
        else if (gamepad1.left_stick_x < 0) {
            motorLeftBack.setPower(-0.5);
            motorLeftFront.setPower(0.5);
            motorRightBack.setPower(-0.5);
            motorRightFront.setPower(0.5);
        }


        // Strafe/Move to the right direction
        else if (gamepad1.left_stick_x > 0) {
            motorLeftBack.setPower(0.5);
            motorLeftFront.setPower(-0.5);
            motorRightBack.setPower(0.5);
            motorRightFront.setPower(-0.5);
        }


        // Stop
        else {
            motorLeftBack.setPower(0);
            motorLeftFront.setPower(0);
            motorRightBack.setPower(0);
            motorRightFront.setPower(0);
        }
    }
}
    private void drive(){
        if (gamepad1.right_bumper){
            driveSpeed = 0.3;
        }
        else{
            driveSpeed = 1;
        }
        arcadeDrive(gamepad1.right_stick_x, gamepad1.left_stick_x, gamepad1.left_stick_y);


    }
}
