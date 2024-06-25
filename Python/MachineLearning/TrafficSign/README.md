# Contour Detection with Color Masks

This program detects contours in an image using color masks based on specific color ranges. It leverages the OpenCV library for image processing and contour detection.

## Features

### Blue Detection (`bluedetection(img)`)
- Detects areas of blue color in the image.
- Converts the image from BGR to HSV color space.
- Applies a mask to isolate blue regions.
- Displays the masked blue areas.

### Red Detection (`reddetection(img)`)
- Detects areas of red color in the image.
- Converts the image from BGR to HSV color space.
- Creates masks for red color in two different ranges and combines them.
- Displays the masked red areas.
- Finds contours of the detected red areas and outlines them on the original image.

### Contour Detection (`contourDetection(img)`)
- Detects contours in the masked image.
- Filters contours based on a specified area threshold.
- Draws bounding rectangles around the detected contours on the original image.

## Requirements

- Python 3.x
- OpenCV (`pip install opencv-python`)
- NumPy (`pip install numpy`)
- Matplotlib (`pip install matplotlib`)
