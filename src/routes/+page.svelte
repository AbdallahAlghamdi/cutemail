<script lang="ts">
  import NavBar from "../components/navbar/NavBar.svelte";
</script>

<div class="window">
  <NavBar />
  <!-- <nav class="titlebar" data-tauri-drag-region> -->
  <!-- <div data-tauri-drag-region class="tool-bar-corner pixel"></div> -->
  <!-- <div class="square-pixel"></div> -->
  <!-- <div data-tauri-drag-region class="tool-bar-middle pattern"></div> -->
  <!-- <div class="tool-bar-right pixel"></div> -->
  <!-- <section class="navbar-actions">
      <button>
        <img src="/piiixl/ui/minimize_button.png" alt="close" />
      </button>
      <button>
        <img src="/piiixl/ui/maximize_button.png" alt="maximize" />
      </button>
      <button>
        <img src="/piiixl/ui/close_button.png" alt="close" />
      </button>
    </section> -->
  <!-- </nav> -->

  <section class="body-content">
    <main></main>
  </section>
</div>

<style>
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
    position: relative;
    height: 100%;
    width: 100%;
    /* background-color: red; */
    background-color: red;
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
  }
  .body-content {
    padding: 0px calc(3px * 5) calc(3px * 7) calc(3px * 3);
    position: relative;
    display: flex;
    justify-content: end;
    align-items: end;
    height: 100%;
    background-color: #e0f8cf;
    /* z-index: 10; */
    /* border: 3px solid black; */

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
    /* Vendor prefixes for broader compatibility, especially with older browsers */
    -webkit-user-select: none; /* Chrome, Safari, Opera */
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
