<%-- 
    Document   : navbar_template
    Created on : Apr 16, 2019, 4:19:49 PM
    Author     : Fabrizio Cruz
--%>

<!-- Navbar de Rastertek -->
<nav class="navbar navbar-light py-sm-1 Raster-Navbar Sticky">
    <a class="navbar-brand" href="CargaIndex">
        <img src="recursos/Logo_v2.PNG" height="70">
    </a>
    <form class="form-inline my-1 my-lg-0">
        <input class="form-control Raster-input" type="search" 
               placeholder="Search" aria-label="Search">
    </form>
    <div>
        <form action="signup.jsp" method="get" style="display: inline">
            <button class="btn Raster-btn my-2 my-sm-0" type="submit">
                Sign in
            </button>
        </form>
        <form action="login.jsp" method="get" style="display: inline">
            <button class="btn Raster-btn-outline my-1 my-sm-0 mx-1" 
                    type="submit">
                Log in
            </button>
        </form>
    </div>
</nav>
