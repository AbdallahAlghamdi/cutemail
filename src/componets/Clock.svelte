<script lang="ts">
    import { onMount } from "svelte";

    let time = $state(new Date());

    let hours = $derived(time.getHours());
    let period = $derived(hours > 12 ? "PM" : "AM");
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

<time datetime={time.toISOString()} class="clock">
    <section>
        <span>{hours % 12}</span>
        <span class="blink">:</span>
        <span>
            {#if minutes < 10}
                0{minutes}
            {:else}
                {minutes}
            {/if}
        </span>
    </section>
    <div class="seperator"></div>
    <p>{period}</p>
</time>

<style>
    @keyframes blink {
        0% {
            opacity: 1;
        }
        50% {
            opacity: 0.5;
        }
        100% {
            opacity: 1;
        }
    }
    section {
        padding: 0px 0px;
        display: flex;
    }
    .blink {
        animation: blink 3s infinite step-start;
    }
    p {
        text-align: center;
    }
    .clock {
        display: flex;
        justify-content: space-evenly;
        /* box-shadow: 0px 0px 5px 0px #303843; */
        border: 2px solid #a57855;
        background-color: #fee1b8;
        font-size: 32px;
        color: #503119;
    }
    .seperator {
        border-left: 3px #a57855 dotted;
    }
</style>
