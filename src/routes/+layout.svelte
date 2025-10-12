<script lang="ts">
  import { getCurrentWindow } from "@tauri-apps/api/window";

  let { children } = $props();

  import LeftWindow from "../componets/LeftWindow.svelte";
  import NavBanner from "../componets/NavBanner.svelte";
</script>

<div class="window" data-tauri-drag-region>
  <LeftWindow username="Garg" />
  <main class="main_window">
    {@render children()}
  </main>
  <aside class="right_window">
    <NavBanner />
  </aside>
</div>

<style>
  @keyframes animated-background {
    from {
      background-position: 0 0;
    }
    to {
      background-position: calc(16px * 3) calc(16px * 3);
    }
  }

  .window {
    height: 100vh;
    background-position: center;
    overflow: hidden;
    display: flex;
    /* border: 3px solid #a57855; */
    background-image: url("/romero/heart-light-pink.png");
    background-size: calc(16px * 3);
    animation: animated-background infinite 2s linear;
  }

  .main_window {
    padding: 13px 30px 0px 35px;
    margin: 8px 0px;
    flex-grow: 1;
    /* background-color: red; */
    border: 3px #303843 solid;
    border-image: url("/srtoasty/book-left-open.png") 33% fill round;
    border-style: solid;
    border-image-slice: 16 16 16 16 fill;
    border-image-width: 48px;
    height: 600px;
  }
  .right_window {
    height: 600px;
    padding: 15px 36px 0px 33px;
    display: flex;
    flex-direction: column;
    border-image: url("/srtoasty/book-right-open.png") 33% fill round;
    border-style: solid;
    border-image-slice: 16 16 16 16 fill;
    border-image-width: 48px;
    margin: 8px;
    margin-left: 0px;
  }

  @font-face {
    font-family: "IBM-VGA";
    src: url("/fonts/WebPlus_IBM_VGA_8x16.woff") format("woff");
    font-weight: normal;
    font-style: normal;
  }

  :global(*, html, body) {
    box-sizing: border-box;
    overscroll-behavior: contain;
    border-spacing: 0px;
    list-style-type: none;
    font-family: "IBM-VGA";
    border: none;
    margin: 0px;
    padding: 0px;
    background-color: transparent;
    image-rendering: pixelated;
    font-smooth: grayscale;
    -webkit-font-smoothing: none;
    -moz-osx-font-smoothing: grayscale;
    cursor: url("icons/mayke_arth/cursor-01.png"), default;
  }
</style>
