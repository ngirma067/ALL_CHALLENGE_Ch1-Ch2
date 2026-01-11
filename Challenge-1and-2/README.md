# CHAPTER 2 CHALLENGE: 
ANSWERS

1. SECURITY:
Based on the "sandbox" model, two things an applet would NOT be allowed to do:
   - Access the local file system (read/write files)
   - Execute system commands or run external programs

2. MODERN REPLACEMENT:
The three modern web technologies that replaced Java Applets are:
   HTML5, CSS3, and JavaScript

Example of bouncing text animation using modern technologies:

HTML:
<div id="bounceContainer">
    <div id="bouncingText">Modern Bouncing Text!</div>
</div>

CSS:
#bounceContainer {
    width: 600px;
    height: 200px;
    background: #222;
    position: relative;
    overflow: hidden;
}
#bouncingText {
    position: absolute;
    color: white;
    font: bold 20px Arial;
    top: 90px;
}

JavaScript:
let position = 0;
let direction = 1;
function animate() {
    position += 5 * direction;
    if (position > 500) direction = -1;
    if (position < 0) direction = 1;
    document.getElementById('bouncingText').style.left = position + 'px';
    requestAnimationFrame(animate);
}
animate();

3. LEGACY:
It's still important for developers to know about applets because:
   - Understanding legacy systems helps maintain old codebases
   - Many enterprise systems still use applet-based applications
   - Applets represent an important chapter in web development history
   - The security concepts (sandbox model) influenced modern web security
   - Helps appreciate the evolution of web technologies and why modern solutions are better
