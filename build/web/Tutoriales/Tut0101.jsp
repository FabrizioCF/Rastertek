<%-- 
    Document   : Tut0101
    Created on : May 11, 2019, 2:58:14 PM
    Author     : Fabrizio Cruz
--%>

<div class="container Raster-content" id="Tut0101">
    <h2>Tutorial 1: Setting up DirectX 11 with Visual Studio</h2>
    <div>
        <p> 
            Before writing any graphics code we'll need to have the tools to do so. The first of these tools is a compiler that is preferably built into a nice IDE. The one I use and will be supplying project files for is Visual Studio 2010. There are several others available and some are even free off the net. I'll leave that up to you to decide which one you prefer.

            The second tool you will need is the DirectX SDK. It can be downloaded from Microsoft's website for free. After downloading and installing the SDK you will have the files necessary to compile DirectX programs. You will also notice it comes with samples, tools, and documentation. The documentation is pretty good, it also has some very simple examples under the DirectX 10 tutorials section which also applies to DirectX 11. The tools that come with it are also useful, we'll be using the DDS texture tool quite often. The sample browser also provides some simple examples to achieve certain effects you may be looking to do. The samples will generally also have some of the new features of the latest SDK demonstrated.

            With both installed you can now setup your IDE to work with the DirectX 11 SDK. Please note that some IDEs will need to be installed first before installing the DirectX SDK.
        </p>

        <h4>Setting Up Visual Studio 2010</h4>

        <p>
            In Visual Studio 2010 I used the following steps:

            First you need to create an empty Win32 project so select File -> New -> Project. Then select Win32 project from the choices. Give the project a name (I called mine Engine) and a location and then click on "Ok". Click "Next" and you will be given another menu. Under "Additional options" put a check mark in the "Empty project" box and click on "Finish" and then click "Next". You should now have an basic Win32 empty project setup.

            Now click "View" from the menu and select "Property Manager".

            Next click on the arrow to the left of your project name (mine was called Engine) in the property manager window on the left part of the screen. This will display the solution configurations you have.

            Select the "Debug | Win32" folder and double click "Microsoft.Cpp.Win32.user".

            In the window that pops up select "VC++ Directories" from the menu on the left side. This will then display the directories that the project uses.

            Now select "Include Directories" from the directory list and click on the down arrow that appears to the left. From the choices it pops up choose "Edit".

            Click on the folder icon at the top (called New Line if you mouse over it) and click on the "..." that appears to the right side.

            Navigate to the DirectX SDK include folder, different versions are named differently but on my system it was: C:\Program Files (x86)\Microsoft DirectX SDK (June 2010)\Include

            Next click on "Select Folder" and then click "Ok".

            The libraries directory is also needed so now select "Library Directories" from the directory list and click on the down arrow that appears to the left. From the choices it pops up choose "Edit".

            Click on the folder icon at the top (called New Line if you mouse over it) and click on the "..." that appears to the right side.

            Navigate to the DirectX SDK library folder, different versions are named differently but on my system it was: C:\Program Files (x86)\Microsoft DirectX SDK (June 2010)\Lib\x86

            Next click on "Select Folder" and then click "Ok".

            Finally click on the "Apply" button in the bottom right of the Property Pages window.

            Now click "Ok" to close the window and your settings will be complete. From the menu click "View" and then "Solution Explorer" to return to your code. All DirectX projects should now compile fine and the error of "Cannot open include file: 'd3d11.h': No such file or directory" should disappear. Also note that these settings will automatically be applied to the Release | Win32 solution configuration so you don't need to set them there. As well it should be persistent permanently for all new projects and will never need to be setup again.
        </p>

        <h4>Setting Up Visual Studio 2008</h4>

        <p>
            In Visual Studio 2008 I used the following steps:

            Click "Tools" from the menu.

            Select "Options" at the bottom of the list.

            Click "Projects and Solutions" from the list on the left side.

            Click "VC++ Directories" from the expanded list.

            On the right side under "Show Directories for:" select the drop down choice "Include files".

            Now add the location of the include directory to the top of the list. On my setup it was the following but may be different on yours (month released, etc.), make sure to double check:

            C:\Program Files (x86)\Microsoft DirectX SDK (June 2010)\Include

            After you have added that include directory you now need to add the library directory also. On the right side under "Show Directories for:" select the drop down choice "Library files".

            On my setup it was the following but may be different on yours (month released, etc.), make sure to double check:

            C:\Program Files (x86)\Microsoft DirectX SDK (June 2010)\Lib\x86

            With these two directories setup in Visual Studio you should now be able to compile DirectX 11 code without any issues. 
        </p>

        <h4>To Do Exercises</h4>

        <p>
            1. Compile and run Tutorial #2 from the DirectX 11 SDK Documentation (source is located: (SDK root)\Samples\C++\Direct3D10\Tutorials\Tutorial02) 
        </p>
    </div>
</div>