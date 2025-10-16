<script lang="ts">
    import Clock from "./Clock.svelte";
    import Day from "./Day.svelte";
    import NavBanner from "./NavBanner.svelte";
    let { username }: { username: string } = $props();
</script>

<aside>
    <Clock />
    <img
        src="https://thumbs.dreamstime.com/b/pixel-stylization-painting-leonardo-da-vinci-mona-lisa-vector-graphics-88304594.jpg"
        alt="avatar"
    />
    <h1>
        <span>@{username}</span>
    </h1>
    <!-- <Day /> -->
    <NavBanner />
</aside>

<style>
    img {
        border: 2px #a57855 solid;
        height: 180px;
        width: 180px;
        object-fit: cover;
        object-position: top;
    }
    h1 {
        text-align: center;
        color: #503119;
        display: flex;
        flex-direction: column;
        padding: 0px 4px;
        border: 2px solid #a57855;
        background-color: #fee1b8;
        font-size: 32px;
    }
    aside {
        display: flex;
        flex-direction: column;
        justify-content: start;
        gap: 8px;
        width: 180px;
        margin: 8px;
        transition: all 0.5s ease-in-out;
    }
    @media (width <= 900px) {
        aside {
            border: none;
            width: 0px;
            overflow: hidden;
            margin: 0px;
            padding: 0px;
        }
    }
</style>
