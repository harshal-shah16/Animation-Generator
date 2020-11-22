package cs5004.animator.model;

/**
 * This class represents the color of a shape in its r,g,b form.
 */
public class Color {

  private int red;
  private int green;
  private int blue;

  /**
   * Constructs an object taking the r, g, b components of a color.
   *
   * @param red   The red component of a color.
   * @param green The green component of a color.
   * @param blue  The blue component of a color.
   */
  public Color(int red, int green, int blue) {
    // Set red, blue, green components to 0 or 255 respectively
    // if the given r, b or g is less than 0 or greater than 255.

    if (green > 255 && red > 255 && blue > 255) {
      this.red = 255;
      this.blue = 255;
      this.green = 255;
    } else if (red > 255 && blue > 255) {
      this.red = 255;
      this.blue = 255;
      this.green = green;
    } else if (blue > 255 && green > 255) {
      this.red = red;
      this.blue = 255;
      this.green = 255;
    } else if (green > 255 && red > 255) {
      this.red = 255;
      this.blue = blue;
      this.green = 255;
    } else if (green < 0 && red < 0 && blue < 0) {
      this.red = 0;
      this.blue = 0;
      this.green = 0;
    } else if (red < 0 && blue < 0) {
      this.red = 0;
      this.blue = 0;
      this.green = green;
    } else if (blue < 0 && green < 0) {
      this.red = red;
      this.blue = 0;
      this.green = 0;
    } else if (green < 0 && red < 0) {
      this.red = 0;
      this.blue = blue;
      this.green = 0;
    } else if (red < 0) {
      this.red = 0;
      this.green = green;
      this.blue = blue;
    } else if (red > 255) {
      this.red = 255;
      this.green = green;
      this.blue = blue;
    } else if (blue < 0) {
      this.blue = 0;
      this.green = green;
      this.red = red;
    } else if (blue > 255) {
      this.blue = 255;
      this.green = green;
      this.red = red;
    } else if (green < 0) {
      this.green = 0;
      this.blue = blue;
      this.red = red;
    } else if (green > 255) {
      this.green = 255;
      this.blue = blue;
      this.red = red;
    } else {
      this.red = red;
      this.green = green;
      this.blue = blue;
    }

  }

  /**
   * Getter for the red component of the color.
   *
   * @return The red component of the color.
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Getter for the Green component of the color.
   *
   * @return The green component of the color.
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Getter for the blue component of the color.
   *
   * @return The blue component of the color.
   */
  public int getBlue() {
    return this.blue;
  }

  /**
   * This method compares the given color with another color.
   *
   * @param toBeCompared The r,g,b components of other color.
   * @return True if the colors are same and false otherwise.
   */
  public boolean compare(Color toBeCompared) {
    return (this.red == toBeCompared.red && this.blue == toBeCompared.blue
            && this.green == toBeCompared.green);
  }

  /**
   * This method creates a String representation of the color components.
   *
   * @return The string representation.
   */
  public String toString() {
    return "(" + String.valueOf(this.red) + "," + String.valueOf(this.green) +
            "," + String.valueOf(this.blue) + ")";
  }

}
