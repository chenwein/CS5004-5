public class PaintTool {
    // draw(something): it will draw the given thing
    // but we need to know its shape and color
    public static void draw(ColorfulThing thingToDraw) {
        // print the description of the thing
        // and its color
        // pretending we're drawing

        // because we know the argument is thingToDraw which
        // provides a method called getColor(), so we can call it
        int color = thingToDraw.getColor();
        String colorStr = null;
        if (color == 1) {
            colorStr = "green";
        } else if (color == 2) {
            colorStr = "yellow";
        }

        System.out.println(thingToDraw.toString() + " " + colorStr);
    }
}
