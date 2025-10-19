<script>
    import NavBanner from "./NavBanner.svelte";
</script>

<aside>
    <NavBanner />
</aside>

<style>
    aside {
        height: 600px;
        padding: 10px;
        /* padding: 5px 36px 0px 33px; */
        display: flex;
        flex-direction: column;
        border-image: url("/srtoasty/book-right-open.png") 33% fill round;
        border-style: solid;
        border-image-slice: 16 16 16 16 fill;
        border-image-width: calc(48px / 2);
        margin: 8px;
        margin-left: 0px;
        transition: all 0.5s ease-in-out;
    }
    @media (width <= 900px) {
        aside {
            border: none;
            width: 0px;
            overflow: hidden;
            height: 0px;
            margin: 0px;
            padding: 0px;
        }
    }
</style>
