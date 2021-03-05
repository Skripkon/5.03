package problem;

import javax.media.opengl.GL2;
import javax.media.opengl.GL;

import static javax.media.opengl.GL.GL_LINE_LOOP;
import static javax.media.opengl.GL.GL_TRIANGLE_FAN;
import static javax.media.opengl.GL2GL3.GL_QUADS;

public class Figures {
    public static void renderPoint(GL2 gl, double posX, double posY, int size) {
        gl.glPointSize(6);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(posX, posY);
        gl.glEnd();
    }
   public static void renderLine(GL2 gl, Point p1, Point p2) {
        gl.glLineWidth(5);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(p1.x, p1.y);
        gl.glVertex2d(p2.x, p2.y);
        gl.glEnd();
    }
   public static void renderTriangle(GL2 gl, Point p1, Point p2, Point p3){

        gl.glBegin(GL.GL_TRIANGLES);
            renderLine(gl, p1, p2);
            renderLine(gl, p2, p3);
            renderLine(gl, p1, p3);
        gl.glEnd();
        }

    public static void renderQuad (GL2 gl, Point p1, Point p2, Point p3, Point p4, boolean filled) {

        if (filled) {
            gl.glBegin(GL_QUADS);
            gl.glVertex2d(p1.x, p1.y);
            gl.glVertex2d(p2.x, p2.y);
            gl.glVertex2d(p3.x, p3.y);
            gl.glVertex2d(p4.x, p4.y);
            gl.glEnd();
        } else {
            renderLine(gl, p1, p2);
            renderLine(gl, p2, p3);
            renderLine(gl, p4, p3);
            renderLine(gl, p1, p4);
        }
    }
        //amountSegments - количество сторон многоугольника (окружность строится как многоугольник)
        public static void renderCircle (GL2 gl, Point p, double rad, boolean filled){
        int amountAngle = 10000;
        double oneSegment = 2* Math.PI / (double) amountAngle;
        if (filled){
            gl.glBegin(GL_TRIANGLE_FAN);
            gl.glVertex2d(p.x, p.y);
            for (int i = 0; i <= amountAngle; i++)   {
                double dx = rad * Math.cos (i * oneSegment);
                double dy = rad * Math.sin (i * oneSegment);
                gl.glVertex2d (p.x + dx, p.y + dy);
            }
            gl.glEnd();
        }
        else {
            gl.glBegin(GL_LINE_LOOP);
            for (int i = 0; i < amountAngle; i++) {
                double angle =  oneSegment * (double) i ;
                double dx = rad * Math.cos(angle);
                double dy = rad * Math.sin(angle);
                gl.glVertex2d(p.x + dx, p.y + dy);
            }
            gl.glEnd();
        }
        }
}
