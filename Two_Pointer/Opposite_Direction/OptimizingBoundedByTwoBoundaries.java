package Opposite_Direction;
//Optimization problems where your answer is literally defined by the gap/distance between two boundary points — capacity planning, scheduling with start/end constraints, geometric area problems.
public class OptimizingBoundedByTwoBoundaries {
    public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0;

    while (left < right) {
        int width = right - left;
        int h = Math.min(height[left], height[right]);
        maxArea = Math.max(maxArea, width * h);

        if (height[left] < height[right]) {
            left++;   // shorter wall is the bottleneck, move it
        } else {
            right--;
        }
    }
    return maxArea;
    }
}
/*
Area = width × min(height[left], height[right]). The shorter wall is always the bottleneck. Moving the taller wall can never increase area (width shrinks, bottleneck stays same or gets worse). Moving the shorter wall is the only move with potential upside — so it's always correct to move the shorter one.
LC Questions:
#Problem11Container With Most Water42Trapping Rain Water845Longest Mountain in Array163Sum Closest */