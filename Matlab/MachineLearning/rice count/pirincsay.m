% input image
image = imread("rice.png");

%image is converted to binary image
binary = imbinarize(image);

%label the binary image
label = bwlabel(binary);

%fill in the blanks in the binary image
label2 = imfill(binary,'holes');

%we define a variable for morphology
SE =strel("disk",4);

%apply imerode to the label2
closeBW=imerode(label2,SE);

figure,imshow(image);
title('input image');
figure,imshow(binary);
title('Image Thresholding')
figure, imshow(closeBW)
title('morphological operations')
figure, imshow(closeBW);
title('The number of rice seeds')

%print how many rice you find in the picture
kenarlar= bwboundaries(closeBW);
text(50,275,strcat('\color{red}',num2str(length(kenarlar)),'\color{red} pieces of rice found'))
hold on;

%color the edges to make them stand out
for k=1:length(kenarlar)
boundary = kenarlar{k};
plot(boundary(:,2),boundary(:,1),'b','LineWidth',1);
end