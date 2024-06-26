document.addEventListener("DOMContentLoaded", function() {
    const sections = document.querySelectorAll(".content > div");
    const navLinks = document.querySelectorAll(".sidebar-nav .nav-link");
    let offsetAdjustment = 90; 

    const updateOffsetAdjustment = () => {
        if (window.innerWidth < 768) {
            offsetAdjustment = 295; 
        } else {
            offsetAdjustment = 160; 
        }
    };


    updateOffsetAdjustment();


    window.addEventListener("resize", updateOffsetAdjustment);

    navLinks.forEach(link => {
        link.addEventListener("click", event => {
        event.preventDefault();
        const targetId = link.getAttribute("href").slice(1);
        const targetSection = document.getElementById(targetId);

        window.scrollTo({
            top: targetSection.offsetTop - offsetAdjustment,
            behavior: "smooth"
        });
        });
    });

    window.addEventListener("scroll", () => {
        const fromTop = window.scrollY;
        
        sections.forEach(section => {
        const sectionTop = section.offsetTop - offsetAdjustment;
        const sectionBottom = sectionTop + section.offsetHeight;

        if (fromTop >= sectionTop && fromTop < sectionBottom) {
            const targetId = section.getAttribute("id");

            navLinks.forEach(link => {
            link.classList.toggle("active", link.getAttribute("href") === `#${targetId}`);
            });
        }
        });
    });
    });