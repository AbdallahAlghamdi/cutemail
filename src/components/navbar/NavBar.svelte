<script lang="ts">
  import { getCurrentWindow } from "@tauri-apps/api/window";
  const appWindow = getCurrentWindow();
</script>

<nav class="no-highlight pattern" data-tauri-drag-region>
  <!-- <div data-tauri-drag-region class="tool-bar-corner pixel"></div> -->

  <h1>Hello</h1>

  <div class="clip lt"></div>
  <div class="clip lb"></div>
  <div class="clip rt"></div>
  <div class="clip rb"></div>

  <div class="clip-alt left"></div>
  <div class="clip-alt right"></div>
  <section>
    <button on:click={appWindow.minimize}>
      <img src="icons/piiixl/ui/minimize_button.png" alt="close" />
    </button>
    <button on:click={appWindow.toggleMaximize}>
      {#await appWindow.isMaximized() then is_maximized}
        {#if is_maximized}
          {is_maximized}

          <img src="icons/piiixl/ui/maximize_alt_button.png" alt="unmaximize" />
        {:else}
          <img src="icons/piiixl/ui/maximize_button.png" alt="maximize" />
        {/if}
      {/await}
    </button>
    <button on:click={appWindow.close}>
      <img src="icons/piiixl/ui/close_button.png" alt="close" />
    </button>
  </section>
</nav>

<style>
  h1 {
    font-size: 32px;
    font-weight: 100;
    color: #e76a3a;
    background-color: #30346d;
    padding: 0px 5px;
    margin: auto;
    border-radius: 1px;
  }
  img {
    width: calc(9px * 3);
    image-rendering: pixelated;
  }
  .clip-alt {
    width: 3px;
    height: 3px;

    position: absolute;
    background-color: #30346d;
  }

  .clip-alt.left {
    left: calc(3px * 1);
    top: calc(3px * 1);
  }
  .clip-alt.right {
    right: calc(3px * 3);
    top: calc(3px * 1);
  }
  nav:hover {
    cursor: grab;
  }
  nav:active {
    cursor: grabbing;
  }
  nav {
    position: relative;
    user-select: none;
    height: calc(16px * 4);
    display: flex;
    flex-shrink: 0;
    align-items: center;
    padding-left: 15px;
    padding-right: calc(3px * 6);
    clip-path: polygon(
      0 3px,
      3px 3px,
      3px 0px,
      calc(100% - 9px) 0px,
      calc(100% - 9px) 3px,
      calc(100% - 6px) 3px,
      calc(100% - 6px) 6px,
      calc(100% - 6px) 9px,
      calc(100% - 3px) 9px,
      calc(100% - 3px) 12px,
      calc(100% - 3px) 15px,
      100% 15px,
      100% 100%,
      0px 100%
    );

    box-shadow:
      inset 0px 3px 0px 0px #30346d,
      inset 3px 0px 0px 0px #30346d,
      inset -9px 0px 0px 0px #30346d,
      inset 0px 6px 0px 0px #e0f8cf,
      inset 6px 0px 0px 0px #e0f8cf,
      inset -12px 0px 0px 0px #e0f8cf,
      inset 0px -9px 0px 0px #e0f8cf;
  }
  nav section {
    display: flex;
    gap: 3px;
    position: absolute;
    right: calc(3px * 5);
  }
  .lt {
    left: calc(3px * 2);
    top: calc(3px * 2);
  }
  .lb {
    left: calc(3px * 2);
    bottom: calc(3px * 3);
  }
  .rt {
    right: calc(3px * 4);
    top: calc(3px * 2);
  }
  .rb {
    right: calc(3px * 4);
    bottom: calc(3px * 3);
  }
  .clip {
    position: absolute;
    width: 3px;
    height: 3px;
    background-color: #e0f8cf;
    /* z-index: 3; */
  }
</style>
