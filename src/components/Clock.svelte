<script lang="ts">
  import { onMount } from "svelte";

  let is_24h = $state(false);
  let time = $state(new Date());

  // these automatically update when `time`
  // changes, because of the $derived
  let hours = $derived(time.getHours());
  let minutes = $derived(time.getMinutes());

  onMount(() => {
    const interval = setInterval(() => {
      time = new Date();
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  });
</script>

<button onclick={() => (is_24h = !is_24h)}>
  <time datetime={time.toString()}>
    <div>
      <span>
        {#if is_24h}
          {hours}
        {:else if hours % 12 == 0}
          12
        {:else if hours % 12 < 9}
          0{hours % 12}
        {:else}
          {hours % 12}
        {/if}
      </span>
      <span class="colon"> : </span>
      <span>
        {#if minutes < 10}
          0{minutes}
        {:else}
          {minutes}
        {/if}
      </span>
    </div>
    {#if !is_24h}
      <span class="period">
        {#if hours <= 12}
          AM
        {:else}
          PM
        {/if}
      </span>
    {/if}
  </time>
</button>

<style>
  @keyframes flicker {
    50% {
      opacity: 20%;
    }
  }

  .colon {
    animation: flicker 2s step-start infinite;
  }
  span {
    display: inline;
    color: #ffbca6;
  }
  div {
    display: flex;
  }
  time {
    justify-content: center;
    gap: 5px;
    display: flex;
    padding: 18px 16px;
    border-image: url("digital-clock.png") 8 fill;
    border-image-width: 18px;
    border-image-repeat: repeat;
    width: 180px;
  }
</style>
