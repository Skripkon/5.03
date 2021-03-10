package problem;
import javax.media.opengl.GL2;
import javax.media.opengl.GL;

public class Triangle {
    /**
     * p1 - первая точка
     */
    Point p1;
    /**
     * p2 - вторая точка
     */
    Point p2;
    /**
     * p3 - третья точка
     */
    Point p3;

    /**
     * Конструктор точки
     *
     * @param p1         первая точка
     * @param p2         вторая точка
     * @param p3         третья точка
     */
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