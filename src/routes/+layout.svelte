<script lang="ts">
  // import { getCurrentWindow } from "@tauri-apps/api/window";

  let { children } = $props();

  import LeftWindow from "$lib/componets/LeftWindow.svelte";
  import NavBanner from "$lib/componets/NavBanner.svelte";
  import RightWindow from "$lib/componets/RightWindow.svelte";
</script>

<div class="window" data-tauri-drag-region>
  <LeftWindow username="Garg" />
  <main class="main_window">
    {@render children()}
  </main>
  <!-- <RightWindow /> -->
</div>

<style>
  @keyframes animated-background {
    from {
      background-position: 0 0;
    }
    to {
      background-position: calc(16px * 2) calc(16px * 2);
    }
  }

  .window {
    cursor: url("icons/mayke_arth/cursor-01.png"), default;

    padding: 0px 8px;
    height: 100vh;
    background-position: center;
    overflow: hidden;
    display: flex;
    /* border: 3px solid #a57855; */
    background-image: url("/romero/heart-light-pink.png");
    background-size: calc(16px * 2);
    animation: animated-background infinite 2s linear;
  }

  main {
    display: flex;
    flex-direction: column;
    padding: 3px 13.5px 20px 13.5px;
    margin: 8px 0px;
    flex-grow: 1;
    overflow: hidden;
    /* background-color: red; */
    /* border: 3px #303843 solid; */
    border-image: url("/srtoasty/single-page-book.png");
    border-style: solid;
    border-image-slice: 16 16 16 16 fill;
    border-image-width: calc(48px / 2);
    max-height: 600px;
  }

  @font-face {
    font-family: "IBM-VGA";
    src: url("/fonts/WebPlus_IBM_VGA_8x16.woff") format("woff");
    font-weight: normal;
    font-style: normal;
  }
  :global(ul ul, ul ol, ol ul, ol ol) {
    padding-left: 15px;
  }
  :global(ol p, ul p) {
    display: inline;
  }
  :global(strong) {
    font-weight: bold !important;
  }
  :global(img) {
    width: calc(16px * 2);
    display: block;
  }

  :global(.pixelCheckbox input[type="checkbox"]) {
    cursor: url("icons/mayke_arth/cursor-06.png"), pointer;

    appearance: none;
    width: calc(16px * 1);
    height: calc(16px * 1);
    background-image: url("/icons/piiixl/ui/checkbox.png");
    background-size: calc(16px * 1);
  }
  :global(.pixelCheckbox input[type="checkbox"]:checked) {
    width: calc(16px * 1);
    height: calc(16px * 1);
    background-image: url("/icons/piiixl/ui/checkbox-active.png");
    background-size: calc(16px * 1);
  }
  :global(*, html, body) {
    font-weight: inherit;
    color: inherit;
    box-sizing: border-box;
    overscroll-behavior: none;
    border-spacing: 0px;
    list-style-position: inside;
    font-family: "IBM-VGA";
    border: none;
    margin: 0px;
    padding: 0px;
    background-color: transparent;
    image-rendering: pixelated;
    font-smooth: grayscale;
    -webkit-font-smoothing: none;
    -moz-osx-font-smoothing: grayscale;
  }
  :global(.banner) {
    border-style: solid;
    border-image: url("/srtoasty/brown-banner.png");
    border-image-slice: 4 4 4 4 fill;
    border-image-width: calc(16px / 2);
    padding: 16px;
    margin: 6px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 16px;
  }
  @media (width <= 900px) {
    .main_window {
      margin: 8px 0px;
      border-image-source: url("/srtoasty/single-page-book.png");
    }
  }
</style>
