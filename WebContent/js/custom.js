// custom.js
document.addEventListener("DOMContentLoaded", function() {
    console.log("JS cargado correctamente!");

    // Ejemplo: resaltar productos
    const productos = document.querySelectorAll(".producto-card");
    productos.forEach(p => {
        p.addEventListener("mouseenter", () => p.classList.add("resaltar"));
        p.addEventListener("mouseleave", () => p.classList.remove("resaltar"));
    });
});/**
 * 
 */