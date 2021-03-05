package problem;
import javax.media.opengl.GL2;
import javax.media.opengl.GL;
public class Line {
    double a,b,c;
    public Line (Point p1, Point p2){
        this.a = p1.y - p2.y;
        this.b = p2.x - p1.x;
        this.c = p1.x*p2.y-p1.y*p2.x;
    }
    /**
     * Рисование прямой
     * @param gl переменная OpenGl для рисования
     */
    void render(GL2 gl) {
        gl.glBegin(GL.GL_POINTS);
        double p1x = -c/a;
        double p2y = -c/b;
        gl.glVertex2d(0, p2y);
        gl.glVertex2d(p1x, 0);
        gl.glEnd();
    }
}
