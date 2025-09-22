<script lang="ts">
  import NavBar from "../components/navbar/NavBar.svelte";
  let { children } = $props();
</script>

<div class="window">
  <NavBar />
  <section class="body-content">
    <main>
      {@render children()}
    </main>
  </section>
</div>

<style>
  @font-face {
    font-family: "IBM-VGA";
    src: url("/fonts/WebPlus_IBM_VGA_8x16.woff") format("woff");
    font-weight: normal;
    font-style: normal;
  }

  main::before {
    content: "";
    width: 3px;
    height: 3px;
    background-color: #30346d;
    position: absolute;
    left: 3px;
    top: 6px;
    z-index: 10;
  }
  main::after {
    content: "";
    width: 3px;
    height: 3px;
    background-color: #30346d;
    position: absolute;
    right: 3px;
    top: 6px;
    z-index: 10;
  }
  main {
    overflow: hidden;
    padding: calc(3px * 3) calc(3px * 3) 10px 10px;
    position: relative;
    flex-grow: 1;
    background-color: #e0f8cf;
    box-shadow:
      inset -3px 3px #30346d,
      inset 3px 6px #30346d,
      inset 0px -3px #30346d;
    clip-path: polygon(
      0px 3px,
      3px 3px,
      3px 0px,
      calc(100% - 3px) 0px,
      calc(100% - 3px) 3px,
      100% 3px,
      100% calc(100% - 3px),
      calc(100% - 3px) calc(100% - 3px),
      calc(100% - 3px) 100%,
      3px 100%,
      3px calc(100% - 3px),
      0px calc(100% - 3px),
      0px 0px
    );
  }
  .window {
    height: 100vh;
    display: flex;
    flex-direction: column;
    overflow: hidden;
  }
  .body-content {
    flex-grow: 1;
    overflow: hidden;
    padding: 0px calc(3px * 4) calc(3px * 4) calc(3px * 2);
    position: relative;
    display: flex;
    flex-direction: column;
    background-color: #e0f8cf;
    box-shadow:
      inset 0px -9px 0px 0px #30346d,
      inset 3px 0px 0px 0px #30346d,
      inset -9px 0px 0px 0px #30346d;
    clip-path: polygon(
      0px 0px,
      100% 0px,
      100% calc(100% - 3px),
      calc(100% - 3px) calc(100% - 3px),
      calc(100% - 3px) 100%,
      15px 100%,
      15px calc(100% - 3px),
      12px calc(100% - 3px),
      12px calc(100% - 6px),
      6px calc(100% - 6px),
      6px calc(100% - 9px),
      3px calc(100% - 9px),
      3px calc(100% - 12px),
      0px calc(100% - 12px)
    );
  }

  .body-content::before {
    content: "";
    width: 3px;
    height: 3px;
    position: absolute;
    bottom: calc(3px * 3);
    right: 9px;
    background-color: #30346d;
  }
  .body-content::after {
    content: "";
    width: 3px;
    height: 3px;
    position: absolute;
    bottom: calc(3px * 3);
    left: 3px;
    background-color: #30346d;
  }
  :global(.no-highlight) {
    user-select: none;
    -webkit-user-select: none;
    -moz-user-select: none; /* Firefox */
    -ms-user-select: none; /* Internet Explorer/Edge */
  }
  :global(button) {
    cursor: pointer;
    height: inherit;
  }
  :global(.pixel) {
    height: calc(16px * 3);
    width: calc(16px * 3);
    background-size: calc(16px * 3);
    image-rendering: pixelated;
    flex-shrink: 0;
  }
  :global(*, html, body, button) {
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
    cursor: url("/srtoasty/cursor.png"), auto;
  }
</style>
