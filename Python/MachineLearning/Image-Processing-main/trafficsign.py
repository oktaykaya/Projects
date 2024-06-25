import cv2
import numpy as np
import matplotlib.pyplot as plt

def bluedetection(img):
    # convert image bgr to hsv
    hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)

    # lower boundary
    lowerbound = np.array([100, 150, 50])

    # upper boundary
    upperbound = np.array([130, 255, 255])

    # make a mask
    mask = cv2.inRange(hsv, lowerbound, upperbound)

    # display the result
    cv2.imshow("blue_mask", mask)
    cv2.waitKey(0)

    return mask

def reddetection(img):
    # convert image bgr to hsv
    hsv_img = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
    # convert image hsv to gray
    gray_img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    
    # lower boundaries
    lowerbound1 = np.array([0, 60, 50])
    upperbound1 = np.array([10, 255, 255])

    # upper boundaries
    lowerbound2 = np.array([139, 60, 50])
    upperbound2 = np.array([180, 255, 255])

    # make two masks
    mask = cv2.inRange(hsv_img, lowerbound1, upperbound1)
    mask2 = cv2.inRange(hsv_img, lowerbound2, upperbound2)

    # adding to masks together
    full_mask = mask + mask2

    # apply the mask
    detect2 = cv2.bitwise_not(img, gray_img, mask=full_mask)

    # find the contours
    contours, hieararch = cv2.findContours(full_mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    # draw the contours
    cnt = cv2.drawContours(img, contours, -1, (0,255,0), 3)
    
    cv2.waitKey(0)
    # display the masked image
    cv2.imshow("red_mask", full_mask)
    cv2.waitKey(0)
    return full_mask



def contourDetection(img):

    # find the contours
    contours, hierarchy = cv2.findContours(img,cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_NONE)
    for cnt in contours:
        area = cv2.contourArea(cnt)

        # put an area limit
        if area > 1800:
            perimeter = cv2.arcLength(cnt,True)
            approx = cv2.approxPolyDP(cnt, 0.02*perimeter,True)
            ObjCor = len(approx)
            x, y, w, h = cv2.boundingRect(approx)

            # draw rectangle
            cv2.rectangle(imgContour, (x,y), (x+w,y+h), (0,255,0),2)


# import the image
img = cv2.imread('BIM472_Images\BIM472_Image20.jpg')
imgContour = img.copy()
red = reddetection(img)
blue = bluedetection(img)

# adding blue and red mask together
full = red + blue 

# creating a kernel
kernel = np.ones((3,3),np.uint8)

# applying opening filter
opening = cv2.morphologyEx(full, cv2.MORPH_OPEN, kernel)

contourDetection(opening)
cv2.imshow("Contour",imgContour)
cv2.waitKey(0)

