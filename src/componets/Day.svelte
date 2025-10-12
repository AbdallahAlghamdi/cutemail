<script lang="ts">
    const Days = [
        "icons/days/Sunday.png",
        "icons/days/Monday.png",
        "icons/days/Tuesday.png",
        "icons/days/Wednesday.png",
        "icons/days/Thursday.png",
        "icons/days/Friday.png",
        "icons/days/Saturday.png",
    ];
    import { onMount } from "svelte";

    let time = $state(new Date());

    let day = $derived(time.getDate());
    let month = $derived(time.getMonth() + 1);
    let year = $derived(time.getFullYear());

    onMount(() => {
        const interval = setInterval(() => {
            time = new Date();
        }, 5000);

        return () => {
            clearInterval(interval);
        };
    });
</script>

<img src={Days[time.getDay()]} alt="day" />
<p>{day}/{month}/{year}</p>

<style>
    p {
        font-size: 32px;
        color: #503119;
        text-align: center;
        border: 3px #a57855 solid;
        background-color: #fee1b8;
    }
    img {
        width: 180px;
        height: 180px;
        border: 3px #a57855 solid;
    }
    .day {
        display: flex;
        color: #503119;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 180px;
        font-weight: 900;
        background-image: url("icons/btl/maroon-pattern.png");
        background-size: 128px;
        image-rendering: pixelated;
        border: 3px #a57855 solid;
        /* background-color: red; */
    }
    .day span {
        box-shadow:
            inset 0px 10px rgb(202, 129, 90),
            inset 0px -19px rgb(202, 129, 90);
        padding: 6px;
        border: 3px #a57855 solid;
        background-color: #fee1b8;
        font-size: 64px;
    }
</style>
