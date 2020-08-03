
/**
* @Description: 接雨水
* @Param:
* @return:
* @Author: liule
* @Date: 2020/8/3
*/
public class 接雨水 {
    public static void main(String[] args) {
        int height[] ={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(height));
    }

    public static int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int maxHeight = 0;
        int left = 0;
        int right = 0;
        int index = 0;
        //整个数组最高点
        for (int i = 0; i < height.length ; i++) {
            if(maxHeight<height[i]){
                maxHeight = height[i];
                index = i;
            }
        }
        //左边接的雨水数量
        for (int i = 0; i < index ; i++) {
           getLeftMaxHeight(i,height);
           left = height[i]<getLeftMaxHeight(i,height)?left+getLeftMaxHeight(i,height)-height[i]:left;
        }
        //右边接的雨水数量
        for (int i = index; i < height.length ; i++) {
            getRightMaxHeight(i,height);
            right= height[i]<getRightMaxHeight(i,height)?right+getRightMaxHeight(i,height)-height[i]:right;
        }
        return right+left;
    }

   /**
   * @Description: 获取当前位置左边最高点。
   * @Param:
   * @return:
   * @Author: liule
   * @Date: 2020/8/3
   */
    public static  int getLeftMaxHeight(int index,int[] height){
        if(index == 0){
            return 0;
        }
        int leftMaxHeight = 0;
        for (int i = 0; i < index ; i++) {
            if(leftMaxHeight<height[i]){
                leftMaxHeight = height[i];
            }
        }
        return leftMaxHeight;
    }

    /**
    * @Description:  获取当前位置右边最高点。
    * @Param:
    * @return:
    * @Author: liule
    * @Date: 2020/8/3
    */
    public static  int getRightMaxHeight(int index,int[] height){
        if(index == height.length ){
            return 0;
        }
        int rightMaxHeight = 0;
        for (int i = index; i < height.length ; i++) {
            if(rightMaxHeight<height[i]){
                rightMaxHeight = height[i];
            }
        }
        return rightMaxHeight;
    }


    /** 
    * @Description: 动态规划 
    * @Param:
    * @return:  
    * @Author: liule
    * @Date: 2020/8/3 
    */
    public static int trap1(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
    public static int trap2(int[] height) {
        int ans=0;
        int n=height.length;
        int left=0,right=n-1;
        int lmax=0,rmax=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>lmax) lmax=height[left];
                else ans+=lmax-height[left];
                left++;
            }
            else{
                if(height[right]>rmax) rmax=height[right];
                else ans+=rmax-height[right];
                right--;
            }
        }
        return ans;
    }

    /**
    * @Description: 双指针
    * @Param:
    * @return:
    * @Author: liule
    * @Date: 2020/8/3
    */
    public static int trap3(int[] height) {
        int ans=0;
        int n=height.length;
        int left=0,right=n-1;
        int lmax=0,rmax=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>lmax) lmax=height[left];
                else ans+=lmax-height[left];
                left++;
            }
            else{
                if(height[right]>rmax) rmax=height[right];
                else ans+=rmax-height[right];
                right--;
            }
        }
        return ans;
    }

}

