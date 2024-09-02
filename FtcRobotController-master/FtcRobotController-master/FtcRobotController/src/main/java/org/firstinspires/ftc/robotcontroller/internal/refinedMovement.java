//Made by Anish
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic Movement", group="Iterative Opmode")
public class BasicMovement extends OpMode {

    // Declare motors
    DcMotor motorLeftBack;
    DcMotor motorLeftFront;
    DcMotor motorRightBack;
    DcMotor motorRightFront;

    private double driveSpeed = 1.0;

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
        // Get the values from the gamepad joysticks
        double drive = -gamepad1.left_stick_y;  // Forward/Backward (inverted Y-axis)
        double strafe = gamepad1.left_stick_x;  // Strafing (left/right)

        // Calculate power for each motor
        double leftFrontPower = drive + strafe;
        double leftBackPower = drive - strafe;
        double rightFrontPower = drive - strafe;
        double rightBackPower = drive + strafe;

        // Apply power to the motors
        motorLeftFront.setPower(Range.clip(leftFrontPower * driveSpeed, -1.0, 1.0));
        motorLeftBack.setPower(Range.clip(leftBackPower * driveSpeed, -1.0, 1.0));
        motorRightFront.setPower(Range.clip(rightFrontPower * driveSpeed, -1.0, 1.0));
        motorRightBack.setPower(Range.clip(rightBackPower * driveSpeed, -1.0, 1.0));

        // Adjust speed with the bumper
        if (gamepad1.right_bumper) {
            driveSpeed = 0.3;
        } else {
            driveSpeed = 1.0;
        }
    }
}
