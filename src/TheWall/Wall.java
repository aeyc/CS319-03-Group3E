package TheWall;


import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
/**
Creator: Ayca Begum Tascioglu & Erdem Ege Marasli
 This class provides the attributes of a wall object. Wall object created by WallEdges and WallLines
 */

public class Wall implements Moveable, Drawable{
    WallEdge[] wallEdges;
    WallLine[] wallLines;

    int initialPositionX;
    int initialPositionY;

    int midPointX;
    int midPointY;

    int wallNumber;

    boolean isMoving;

    int fixedInitialPositionX;
    int fixedInitialPositionY;

    int fixedMidPointX;
    int fixedMidPointY;
    boolean isPlaced;
    int rotateCount;

    public Wall(WallEdge[] wallEdges, WallLine[] wallLines,int wallNumber)
    {
        this.wallEdges = wallEdges;
        this.wallLines = wallLines;
        this.wallNumber = wallNumber;
        rotateCount = 0;
        isMoving = false;
        isPlaced = false;
    }


    /*
    SETTERS
     */

    public int getRotateCount() {
        return rotateCount;
    }

    public void setRotateCount(int rotateCount) {
        this.rotateCount = rotateCount;
    }

    public void setWallNumber(int wallNumber) {
        this.wallNumber = wallNumber;
    }

    public boolean isPlaced(){
        return isPlaced;
    }
    public void setPlaced(boolean b){
        isPlaced = b;
    }

    public void setMidPointX(int midPointX) {
        this.midPointX = midPointX;
    }

    public void setMidPointY(int midPointY) {
        this.midPointY = midPointY;
    }

    public void setInitialPositionX(int initialPositionX) {
        this.initialPositionX = initialPositionX;
    }

    public void setInitialPositionY(int initialPositionY) {
        this.initialPositionY = initialPositionY;
    }

    public void setWallEdges(WallEdge[] wallEdges) {
        this.wallEdges = wallEdges;
    }

    public void setWallLines(WallLine[] wallLines) {
        this.wallLines = wallLines;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void setFixedInitialPositionX(int fixedInitialPositionX) {
        this.fixedInitialPositionX = fixedInitialPositionX;
    }

    public void setFixedInitialPositionY(int fixedInitialPositionY) {
        this.fixedInitialPositionY = fixedInitialPositionY;
    }

    public void setFixedMidPointX(int fixedMidPointX) {
        this.fixedMidPointX = fixedMidPointX;
    }

    public void setFixedMidPointY(int fixedMidPointY) {
        this.fixedMidPointY = fixedMidPointY;
    }

    /**
     * rotates the wall 90 degrees in Clockwise according to current postion and mid points.
     */
    public void rotate(){

        for(int i = 0; i < wallLines.length; i++){
            AffineTransform transform = new AffineTransform();
            Rectangle newRec = new Rectangle(wallLines[i].getX(),wallLines[i].getY(), wallLines[i].getWidth(), wallLines[i].getHeight());
            transform.rotate(Math.toRadians(90),  midPointX, midPointY);
            Shape transformed = transform.createTransformedShape(newRec);
            //System.out.println((int)(transformed.getBounds().getX()));
            wallLines[i].setX((int)(transformed.getBounds().getX()));
            wallLines[i].setY((int)(transformed.getBounds().getY()));
            wallLines[i].setWidth((int)(transformed.getBounds().getWidth()));
            wallLines[i].setHeight((int)(transformed.getBounds().getHeight()));

        }

        for(int i = 0; i < wallEdges.length; i++){
            AffineTransform transform = new AffineTransform();
            Rectangle newRec = new Rectangle(wallEdges[i].getX(),wallEdges[i].getY(), wallEdges[i].getRadius(), wallEdges[i].getRadius());
            transform.rotate(Math.toRadians(90), midPointX, midPointY);
            Shape transformed = transform.createTransformedShape(newRec);
            wallEdges[i].setX((int)(transformed.getBounds().getX()));
            wallEdges[i].setY((int)(transformed.getBounds().getY()));
            wallEdges[i].setRadius((int)(transformed.getBounds().getWidth()));

        }
    }

    /**
     *This method checks if the given points are into the wall.
     */
    public boolean isContainMouse(int contX, int contY)
    {
        for(int i = 0; i < wallLines.length; i++){
            if(contX >= wallLines[i].getX() && contX <= (wallLines[i].getX() ) + (wallLines[i].getWidth() ) &&
                    contY >= wallLines[i].getY() && contY <= (wallLines[i].getY() ) + (wallLines[i].getHeight() ) ) {
                return true;
            }
        }
        for(int i = 0; i < wallEdges.length; i++){
            if(contX >= wallEdges[i].getX() && contX <= (wallEdges[i].getX() ) + (wallEdges[i].getRadius() ) &&
                    contY >= wallEdges[i].getY() && contY <= (wallEdges[i].getY() ) + (wallEdges[i].getRadius() ) ) {
                return true;
            }
        }
        return false;
    }


    /*
    GETTERS
     */

    public int getWallNumber() {
        return wallNumber;
    }

    public int getMidPointX() {
        return midPointX;
    }

    public int getMidPointY() {
        return midPointY;
    }

    public int getInitialPositionY() {
        return initialPositionY;
    }

    public int getInitialPositionX() {
        return initialPositionX;
    }

    public int getFixedInitialPositionY() {
        return fixedInitialPositionY;
    }

    public int getFixedInitialPositionX() {
        return fixedInitialPositionX;
    }

    public int getFixedMidPointX() {
        return fixedMidPointX;
    }

    public int getFixedMidPointY() {
        return fixedMidPointY;
    }

    public WallEdge[] getWallEdges() {
        return wallEdges;
    }

    public WallLine[] getWallLines() {
        return wallLines;
    }

    @Override
    public void setX(int x) {
        int temp = x - midPointX;
        for(int i = 0; i < wallLines.length; i++)
            wallLines[i].setX((wallLines[i].getX() + temp));
        if(wallEdges != null){
            for(int i = 0; i < wallEdges.length; i++)
                wallEdges[i].setX((wallEdges[i].getX() + temp));
        }
        setMidPointX(x);
    }

    @Override
    public void setY(int y) {
        int temp = y - midPointY;
        for(int i = 0; i < wallLines.length; i++)
            wallLines[i].setY((wallLines[i].getY() + temp));
        if(wallEdges != null){
            for(int i = 0; i < wallEdges.length; i++)
                wallEdges[i].setY((wallEdges[i].getY() + temp));
        }
        setMidPointY(y);
    }

    @Override
    public int getY() {
        return midPointY;
    }

    @Override
    public int getX() {
        return midPointY;
    }
    public void draw(Graphics g) {
        for(int i = 0; i < wallLines.length; i++)
            wallLines[i].draw(g);
        if(wallEdges != null){
            for(int i = 0; i < wallEdges.length; i++)
                wallEdges[i].draw(g);
        }

    }

    public void setFixed(){
        for(int i = 0; i < wallLines.length; i++){
            wallLines[i].setX(wallLines[i].getFixedX());
            wallLines[i].setY(wallLines[i].getFixedY());
        }
        for(int i = 0; i < wallEdges.length; i++){
            wallEdges[i].setX(wallEdges[i].getFixedX());
            wallEdges[i].setY(wallEdges[i].getFixedY());
        }
    }

    public void setFixedInitial(){
        this.setInitialPositionX(this.getFixedInitialPositionX());
        this.setInitialPositionY(this.getFixedInitialPositionY());
    }

    public void setFixedMidpoint(){
        this.setMidPointX(this.getFixedMidPointX());
        this.setMidPointY(this.getFixedMidPointY());
    }
    public void makeGreen(boolean b){

        for(int i = 0; i < wallLines.length; i++){
            wallLines[i].makeGreen(b);
        }
        for(int i = 0; i < wallEdges.length; i++){
            wallEdges[i].makeGreen(b);
        }

    }

    public boolean isMoving() {
        return isMoving;
    }
}