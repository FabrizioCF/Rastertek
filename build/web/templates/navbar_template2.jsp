<%-- 
    Document   : navbar_template2
    Created on : May 4, 2019, 1:59:57 AM
    Author     : Fabrizio Cruz
--%>

<!-- Navbar de Rastertek -->
<nav class="navbar navbar-light py-sm-1 Sticky">
    <a class="navbar-brand" href="CargaIndex">
        <img src="recursos/Logo_v2.PNG" height="70">
    </a>
    <form class="form-inline my-1 my-lg-0">
        <input class="form-control Raster-input" type="search" 
               placeholder="Search" aria-label="Search">
    </form>
    <div>
        <h3 class="my-2 my-sm-0" id="nombreUs">
            <%= session.getAttribute("nombreUsuario")%>
        </h3>
        <form action="CierraSesion" method="GET" style="display: inline">
            <button class="btn Raster-btn-outline my-1 my-sm-0 mx-1" 
                    type="submit"> Log out
            </button>
        </form>
    </div>
</nav>