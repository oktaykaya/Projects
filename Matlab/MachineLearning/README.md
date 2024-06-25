
# Rice Seed Counting using Image Processing in MATLAB

This MATLAB script counts the number of rice seeds in an image using image processing techniques such as thresholding, morphological operations, and contour detection.

## Overview

### Steps:

1. **Image Input and Thresholding:**
   - The input image (`rice.png`) is read and converted to a binary image using global thresholding (`imbinarize`).

2. **Labeling and Hole Filling:**
   - The binary image is labeled (`bwlabel`) to identify connected components.
   - Holes within the labeled regions are filled using `imfill`.

3. **Morphological Operations:**
   - A disk-shaped structuring element (`strel`) with radius 4 is defined.
   - Morphological erosion (`imerode`) is applied to further refine the filled image.

4. **Visualization and Counting:**
   - Several figures are displayed to visualize different stages of processing:
     - Original input image.
     - Binary image after thresholding.
     - Result of morphological operations.
     - Overlay showing the number of rice seeds counted.

5. **Boundary Tracing and Display:**
   - Boundary tracing (`bwboundaries`) is used to detect and outline the boundaries of rice seeds.
   - The number of detected rice seeds is counted and displayed on the image.
   - Boundaries are overlaid on the original image to visually mark the rice seeds.

## Requirements

- MATLAB with Image Processing Toolbox

## Usage

1. Ensure MATLAB is installed on your system.
2. Place your image (`rice.png`) in the same directory as the script.
3. Run the script (`rice_seed_count.m`).
4. View the generated figures to observe the image processing steps and the counted rice seeds.

## Notes

- Adjust the parameters (`disk radius`, thresholding method) based on your specific images.
- Ensure the input image (`rice.png`) has sufficient contrast between rice seeds and the background.
- Modify the plotting and visualization options (`imshow`, `title`, `text`, `plot`) as needed for better presentation.
