<script lang="ts">
  import type { MouseEventHandler } from "svelte/elements";

  interface props {
    onclick: MouseEventHandler<HTMLButtonElement>;
    src: string;
    title: string;
    alt: string;
    hover_src?: string;
  }
  let { onclick, src, title, alt, hover_src }: props = $props();
</script>

<button {title} {onclick}>
  <img {src} {alt} />
</button>

<style>
  button {
    cursor: url("icons/mayke_arth/cursor-06.png"), pointer;
  }
</style>
