package problem;
import javax.media.opengl.GL2;
import javax.media.opengl.GL;

public class Triangle {
    Point p1, p2, p3;
    public Triangle (Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    /**
     * Рисование треугольника
     * @param gl переменная OpenGl для рисования
     */
      void render(GL2 gl, Point p1, Point p2, Point p3){
        gl.glBegin(GL.GL_TRIANGLES);
        Figures.renderLine(gl, p1, p2);
        Figures.renderLine(gl, p2, p3);
        Figures.renderLine(gl, p1, p3);
        gl.glEnd();
    }
}