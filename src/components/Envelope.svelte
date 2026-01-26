<script lang="ts">
    let { sender } = $props();
</script>

<section class="envelope">
    <div class="sender">
        <section>
            {sender}
            <time>01-11-2011</time>
        </section>
        <img src="srtoasty/stamps/stamp-blue.png" alt="blue stamp" />
    </div>
</section>

<style>
    section {
        display: flex;
        flex-direction: column;
        gap: 8px;
    }
    .envelope {
        position: relative;
        top: 10px;
        margin-top: 50px;
        height: 250px;
        width: 470px;
        border-image: url("letter.png") 8 fill;
        border-image-width: 18px;
        border-image-repeat: repeat;
    }
    .sender {
        padding: 8px;
        display: flex;
        gap: 8px;
        justify-content: space-between;
    }
    img {
        width: calc(16px * 3);
        height: calc(16px * 3);
    }
</style>
