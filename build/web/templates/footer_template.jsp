<%-- 
    Document   : footer_template
    Created on : Apr 16, 2019, 4:40:10 PM
    Author     : Fabrizio Cruz
--%>

<!-- Footer de Rastertek -->
<footer class="container-fluid Raster-footer py-3">
    <div class="row">
        <div class="col-sm-2 my-auto">
            <a class="d-block text-center" href="CargaIndex?verAbout=1">About</a>
        </div>
        <div class="col-sm-2 my-auto">
            <a class="d-block text-center" href="#">Contact</a>
        </div>
        <div class="col-sm-4 text-center">
            <a href="CargaIndex">
                <img src="recursos/Logo_v2.PNG" height="60">
            </a>
            <figcaption class="Raster-labels">ALL RIGHTS RESERVED &reg
            </figcaption>
        </div>
        <div class="col-sm-2">
            <label class="Raster-labels">Follow us on:</label><br>
            <img id="FB" src="https://img.icons8.com/color/48/000000/facebook.png">
            <img src="https://img.icons8.com/color/48/000000/twitter.png">
        </div>
        <div class="col-sm-2 px-0">
            <label class="Raster-labels">Subscribe to the newsletter!</label>
            <br>
            <form action="EnvioCorreos" method="post" class="form-inline my-1 my-lg-0">
                <input id="subscribe-correo" name="correo" class="form-control Raster-input" 
                       type="email" placeholder="Your email"
                       aria-label="Correo">
            </form>
        </div>
    </div>
</footer>
