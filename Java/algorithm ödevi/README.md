# Closest Point Pair Algorithm in Java

This repository contains a Java implementation of the Closest Point Pair algorithm, which finds the pair of points that are closest to each other in a given set of points. The implementation includes classes for managing points, quick sorting, and finding the closest pair using both divide-and-conquer and brute-force approaches.

## Classes

1. **FindClosest**: Main class for finding the closest point pair.
2. **PointPair**: Represents a pair of points and calculates the distance between them.
3. **QuickSort**: Provides quicksort functionality for sorting points.
4. **TestClosestPointPair**: Test class for running the algorithm on various datasets.

## FindClosest Class

### Description

The `FindClosest` class calculates the closest pair of points from an array of points. It first sorts the points by their x-coordinates and then uses a recursive method to find the closest pair.

### Methods

- **`FindClosest(Point2D.Double[] points)`**: Constructor that initializes the class with an array of points, sorts them, and calculates the closest point pair.
- **`PointPair getClosestPointPair()`**: Returns the closest point pair found.
- **`private PointPair calculateClosestPointPair(Point2D.Double[] p, int startIndex, int lastIndex)`**: Main method for calculating the closest point pair recursively.
- **`private PointPair getClosestPointPair(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3)`**: Helper method for finding the closest pair among three points.
- **`private PointPair getClosestPointPair(PointPair p1, PointPair p2)`**: Helper method for comparing two point pairs and returning the closer one.
- **`private PointPair stripClosest(Point2D.Double strip[], int size, PointPair shortestLine)`**: Utility function to find the closest points in a given strip.

## PointPair Class

### Description

The `PointPair` class represents a pair of points and provides methods to calculate the distance between them and normalize the order of points.

### Methods

- **`PointPair(Point2D.Double p1, Point2D.Double p2)`**: Constructor that initializes the class with two points.
- **`Point2D.Double getPoint1()`**: Returns the first point.
- **`Point2D.Double getPoint2()`**: Returns the second point.
- **`double getDistance()`**: Calculates and returns the distance between the two points.
- **`PointPair normalize()`**: Normalizes the order of points based on their coordinates.
- **`String toString()`**: Returns a string representation of the point pair and the distance between them.

## QuickSort Class

### Description

The `QuickSort` class provides methods to sort an array of points based on their x or y coordinates using the quicksort algorithm.

### Methods

- **`QuickSort()`**: Default constructor.
- **`void sort(Point2D.Double[] arr, int startIndex, int lastIndex, String orderBy)`**: Main function to sort the array.
- **`private void swap(Point2D.Double[] arr, int i, int j)`**: Utility function to swap two elements in the array.
- **`private Point2D.Double getMedianX(Point2D.Double[] arr, int left, int right)`**: Finds the median of three points based on their x-coordinates.
- **`private Point2D.Double getMedianY(Point2D.Double[] arr, int left, int right)`**: Finds the median of three points based on their y-coordinates.
- **`private int partitionX(Point2D.Double[] arr, int startIndex, int lastIndex)`**: Partitions the array for quicksort based on x-coordinates.
- **`private int partitionY(Point2D.Double[] arr, int startIndex, int lastIndex)`**: Partitions the array for quicksort based on y-coordinates.

## TestClosestPointPair Class

### Description

The `TestClosestPointPair` class tests the `FindClosest` algorithm with various datasets.

### Methods

- **`static Point2D.Double[] ReadFile(String filePath)`**: Reads points from a file and returns an array of points.
- **`public static void main(String[] args)`**: Main method that tests the algorithm with different datasets and prints the closest point pairs along with their distances.
