package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Заданы два множества точек в пространстве.\n" +
            "Требуется построить пересечения и разность этих множеств";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Иванова Ивана";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Line> lines;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        lines = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x      координата X точки
     * @param y      координата Y точки
     * @param setVal номер множества
     */
    public void addPoint(double x, double y, int setVal) {
        Point point = new Point(x, y, setVal);
        points.add(point);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них совпадают
                    if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
                        p.isSolution = true;
                        p2.isSolution = true;
                    }
                }
            }
        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                int setVal = sc.nextInt();
                sc.nextLine();
                Point point = new Point(x, y, setVal);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f %d\n", point.x, point.y, point.setNumber);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        for (Point point : points) {
            point.render(gl);
        }
        for (Line l : lines) {
            l.render(gl);
        }
        /*
        Point p1 = new Point(0.3,0.3);
        Point p2 = new Point(-0.5,0.3);
        Point p3 = new Point(-0.7,-0.4);
        Point p4 = new Point(0.2,-0.2);
        Point p5 = new Point(0.4,-1);
        Point p6 = new Point(-0.76,-0.34);
        Point p7 = new Point(-0.3,0.8);
        Point p8 = new Point(-0.4,0.2);
        Point p9 = new Point(-0.5,0.9);
        Point p10 = new Point(0,0);
        Figures.renderPoint(gl,1, 1, 6);
        Figures.renderLine(gl, p1, p2);
        gl.glColor3d(1, 1, 1);
        Figures.renderTriangle(gl, p8, p3, p6);
        Figures.renderTriangle(gl, p8, p9, p4);
        Figures.renderQuad(gl, p1, p5, p6, p3, false);
        gl.glColor3d(0, 0, 1);
        Figures.renderQuad(gl, p1, p2, p3, p4, true);
        Figures.renderCircle(gl, p1, 0.5, false);
        gl.glColor4f(1.0f, 1.0f, 1.0f, 0.0f);//white
        Figures.renderQuad(gl, new Point(-0.75,0.5), new Point(0.75,0.5), new Point(0.75,-0.5), new Point(-0.75,-0.5), true);
        gl.glColor3d(1, 0, 0);
        Figures.renderCircle(gl, p10, 0.25, true);
        gl.glColor4f(1.0f, 0.0f, 1.0f, 0.0f);//purple
        Figures.renderCircle(gl, p8, 0.34, false);
    }



         */
    }
}

