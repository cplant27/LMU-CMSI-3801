import java.util.*;
import java.util.stream.Stream;

public class Quaternion {
        public double co1, co2, co3, co4;

        public Quaternion(double a, double b, double c, double d) {
            this.co1 = a;
            this.co2 = b;
            this.co3 = c;
            this.co4 = d;
        }

        public Quaternion plus(Quaternion q) {
            Quaternion answer = new Quaternion(
            this.co1 + q.co1,
            this.co2 + q.co2,
            this.co3 + q.co3,
            this.co4 + q.co4
            );
            return answer;
        }

        public Quaternion minus(Quaternion q) {
            Quaternion answer = new Quaternion(
            this.co1 - q.co1,
            this.co2 - q.co2,
            this.co3 - q.co3,
            this.co4 - q.co4
            );
            return answer;
        }

        public Quaternion times(Quaternion q) {
            double ans1 = this.co1 * q.co1 - this.co2 * q.co2 - this.co3 * q.co3 - this.co4 * q.co4;
            double ans2 =
            this.co1 * q.co2 + this.co2 * q.co1 + this.co3 * q.co4 - this.co4 * q.co3;
            double ans3 =
            this.co1 * q.co3 - this.co2 * q.co4 + this.co3 * q.co1 + this.co4 * q.co2;
            double ans4 =
            this.co1 * q.co4 + this.co2 * q.co3 - this.co3 * q.co2 + this.co4 * q.co1;
            return new Quaternion(ans1, ans2, ans3, ans4);
        }

        public List coefficients() {
            List coefficients = new ArrayList();
            coefficients.add(this.co1);
            coefficients.add(this.co2);
            coefficients.add(this.co3);
            coefficients.add(this.co4);
            return coefficients;
        }

        public String toString() {
            return "Quaternion[a="+String.valueOf(this.co1)+", b="+String.valueOf(this.co2)+", c="+String.valueOf(this.co3)+", d="+String.valueOf(this.co4)+"]";
        }


    } 