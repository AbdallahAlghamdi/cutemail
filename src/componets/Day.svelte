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
        border: 2px #a57855 solid;
        background-color: #fee1b8;
    }
    img {
        width: 180px;
        height: 180px;
        border: 2px #a57855 solid;
    }
</style>
