
public class NBody {
    public static double readRadius(String FileName){
        In in = new In(FileName);
        int numPlanet;
        double radius;

        numPlanet = in.readInt();
        radius =in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String FileName){
        In in = new In(FileName);
        int numPlanet;
        double radius;

        numPlanet = in.readInt();
        radius = in.readDouble();
        Body[] Bodys = new Body[numPlanet];

        for (int i = 0; i < numPlanet; i ++){
            Bodys[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return Bodys;
    }

    public static void main(String[] args){
        /* Parse arguments */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];

        /* Read in data */
        double radius = readRadius(fileName);
        Body[] bodies = readBodies(fileName);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        Double[] xForces = new Double[bodies.length];
        Double[] yForces = new Double[bodies.length];

        /* Play the theme to 2001: A Space Odyssey */
        StdAudio.play("audio/2001.mid");

        Double currentTime = 0.0;
        while (currentTime < T) {
            /* Calculate the net forces for each Body */
            for (int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            /* Update each Body’s position, velocity, and acceleration */
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            /* Draw the background */
            String background = "images/starfield.jpg";
            StdDraw.picture(0, 0, background);
            /* Draw all the bodies */
            for (Body b : bodies) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

            currentTime += dt;
        }

        

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                      bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                      bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
        
    }
}
