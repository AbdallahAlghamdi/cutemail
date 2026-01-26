<script lang="ts">
  import "$lib/global.css";
  import SideMenu from "../components/SideMenu.svelte";
  let { children } = $props();
</script>

<SideMenu />
<main>
  {@render children()}
</main>

<style>
  main {
    flex-grow: 1;
    border-image: url("srtoasty/notebook.png") 16 fill repeat;
    border-style: solid;
    border-image-width: 32px;
    padding-left: 30px;
    padding-top: 10px;
    padding-bottom: 15px;
    padding-right: 12px;
    overflow: hidden;
    /* background-color: red; */
  }
  :global(body) {
    background-image: url("backgrounds/heart-pink.png");
    background-size: calc(16px * 2);
    animation: scroll-bottom-left 1s linear infinite;
  }
</style>
