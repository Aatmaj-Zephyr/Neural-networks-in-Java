# Python program to convert
# numpy array to image
  
# import required libraries
import numpy as np
from PIL import Image as im
  
# define a main function
def main():
  
    # create a numpy array from scratch
    # using arange function.
    # 1024x720 = 737280 is the amount 
    # of pixels.
    # np.uint8 is a data type containing
    # numbers ranging from 0 to 255 
    # and no non-negative integers
    str="127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,255,255,255,255,255,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,0,0,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,255,0,0,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,0,0,0,0,0,0,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,0,0,0,0,0,0,0,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,0,0,0,0,0,0,255,255,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,255,0,0,255,255,255,255,255,0,0,0,255,127,127,127,127,127,127,127,127,127,127,127,127,127,127,255,255,255,255,255,255,255,255,127,127,0,0,255,0,255,0,127,127,127,127,127,127,127,127,127,127,127,127,255,0,255,255,255,255,127,127,127,127,127,0,255,255,0,255,127,127,127,127,127,127,127,127,127,127,127,127,0,0,255,255,0,127,127,127,127,127,127,255,255,255,0,0,127,127,127,127,127,127,127,127,127,127,127,127,0,0,0,127,127,127,127,127,127,127,127,255,255,255,255,255,127,127,127,127,127,127,127,127,127,127,127,127,0,255,0,127,127,127,127,127,127,127,127,255,255,0,255,255,127,127,127,127,127,127,127,127,127,127,127,127,255,0,0,127,127,127,127,127,127,255,255,255,255,0,0,0,127,127,127,127,127,127,127,127,127,127,127,127,255,255,0,127,127,127,127,127,127,255,255,0,0,255,255,127,127,127,127,127,127,127,127,127,127,127,127,127,255,255,255,127,127,127,127,127,255,255,0,0,0,255,127,127,127,127,127,127,127,127,127,127,127,127,127,127,255,255,255,0,255,0,0,255,255,255,255,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,255,255,255,0,255,255,0,0,0,255,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,0,0,0,0,0,0,0,0,255,0,0,255,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,0,0,0,0,0,0,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,0,0,0,0,0,0,0,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127,127"
  
    str=str.split(",")
  
      
    # Reshape the array into a 
    # familiar resoluition

    array = np.reshape(str, (28, 28)).astype(np.uint8)
      
    # show the shape of the array
    print(array.shape)
  
    # show the array
    print(array)
      
    # creating image object of
    # above array
    data = im.fromarray(array)
      
    # saving the final output 
    # as a PNG file
    data.save('gfg_dummy_pic9.png')
  
# driver code
if __name__ == "__main__":
    
  # function call
  main()