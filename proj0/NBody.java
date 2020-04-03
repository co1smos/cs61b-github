
public class NBody {
    public static String imageToDraw = "starfield.jpg";

    public static double readRadius (String FileAddress) {
        In in = new In(FileAddress);
        int numsofPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets (String FileAddress) {
        In in = new In(FileAddress);
        int numsofPlanets = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[numsofPlanets];
        for (int i = 0; i < numsofPlanets; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), 
                    in.readDouble(), in.readDouble(), in.readString());
        }
        return planets;
    }

    public static void main (String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int numsofPlanets = planets.length;

        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/"+imageToDraw);
        for (Planet p : planets) p.draw();

        StdDraw.enableDoubleBuffering();

        double time = 0;
        for (time = 0; time < T; time += dt) {
            double[] xForces = new double[numsofPlanets];
            double[] yForces = new double[numsofPlanets];
            for (int i = 0; i < numsofPlanets; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < numsofPlanets; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/"+imageToDraw);
            for (Planet p : planets) p.draw();
            StdDraw.show();
			StdDraw.pause(10);
        }
        
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}