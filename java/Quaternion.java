import java.util.*;
import java.util.stream.Stream;

public class Quaternion {
        public double a, b, c, d;
        public static final Quaternion ZERO = new Quaternion(0.0, 0.0, 0.0, 0.0);
        public static final Quaternion K = new Quaternion(0.0, 0.0, 0.0, 1);
        public static final Quaternion I = new Quaternion(0.0, 0.0, 0.0, 1);
        public static final Quaternion J = new Quaternion(0.0, 0.0, 0.0, 1);

        public Quaternion(double a, double b, double c, double d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public Quaternion plus(Quaternion q) {
            Quaternion answer = new Quaternion(
            this.a + q.a,
            this.b + q.b,
            this.c + q.c,
            this.d + q.d
            );
            return answer;
        }

        public Quaternion minus(Quaternion q) {
            Quaternion answer = new Quaternion(
            this.a - q.a,
            this.b - q.b,
            this.c - q.c,
            this.d - q.d
            );
            return answer;
        }

        public Quaternion times(Quaternion q) {
            double ans1 = this.a * q.a - this.b * q.b - this.c * q.c - this.d * q.d;
            double ans2 =
            this.a * q.b + this.b * q.a + this.c * q.d - this.d * q.c;
            double ans3 =
            this.a * q.c - this.b * q.d + this.c * q.a + this.d * q.b;
            double ans4 =
            this.a * q.d + this.b * q.c - this.c * q.b + this.d * q.a;
            return new Quaternion(ans1, ans2, ans3, ans4);
        }

        public List coefficients() {
            List coefficients = new ArrayList();
            coefficients.add(this.a);
            coefficients.add(this.b);
            coefficients.add(this.c);
            coefficients.add(this.d);
            return coefficients;
        }

        public String toString() {
            return "Quaternion[a="+String.valueOf(this.a)+", b="+String.valueOf(this.b)+", c="+String.valueOf(this.c)+", d="+String.valueOf(this.d)+"]";
        }


    } 