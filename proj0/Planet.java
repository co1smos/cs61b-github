
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    public Planet (double xP, double yP, double xV, 
                    double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet (Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance (Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance;
    }

    public double calcForceExertedBy (Planet p) {
        double distance = calcDistance(p);
        double F = (G*mass*p.mass)/(distance*distance);
        return F;
    }

    public double calcForceExertedByX (Planet p) {
        double distanceX = p.xxPos - xxPos;
        double distance = calcDistance(p);
        double Fx = calcForceExertedBy(p)*distanceX/distance;
        return Fx;
    }
    
    public double calcForceExertedByY (Planet p) {
        double distanceY = p.yyPos - yyPos;
        double distance = calcDistance(p);
        double Fy = calcForceExertedBy(p)*distanceY/distance;
        return Fy;
    }

    public boolean equals (Planet p) {
        if (xxPos == p.xxPos && 
            yyPos == p.yyPos &&
            xxVel == p.xxVel &&
            yyVel == p.yyVel &&
            mass == p.mass
        ) return true;
        else return false;
    }

    public double calcNetForceExertedByX (Planet[] planets) {
        int numofPlanets = planets.length;
        double NetFx = 0.0;
        for (int i = 0; i < numofPlanets; i++) {
            if (!equals(planets[i])) NetFx += calcForceExertedByX(planets[i]);
        }
        return NetFx;
    }

    public double calcNetForceExertedByY (Planet[] planets) {
        int numofPlanets = planets.length;
        double NetFy = 0.0;
        for (int i = 0; i < numofPlanets; i++) {
            if (!equals(planets[i])) NetFy += calcForceExertedByY(planets[i]);
        }
        return NetFy;
    }

    public void update (double dt, double x_force, double y_force) {
        double ax = x_force/mass;
        double ay = y_force/mass;
        xxVel += dt*ax;
        yyVel += dt*ay;
        xxPos += dt*xxVel;
        yyPos += dt*yyVel;
    }

    public void draw () {
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
} 